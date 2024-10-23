package id.ellinda.myschedule

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.Spring
import androidx.compose.foundation.Image
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.unit.sp
import id.ellinda.myschedule.data.Schedule
import id.ellinda.myschedule.data.schedules
import id.ellinda.myschedule.ui.theme.MyScheduleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyScheduleTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ScheduleApp()
                }
            }
        }
    }
}

@Composable
fun ScheduleApp() {
    Scaffold(topBar = { ScheduleTopAppBar() }) { paddingValues ->
        LazyColumn(contentPadding = paddingValues) {
            items(schedules) { schedule ->
                ScheduleItem(
                    schedule = schedule,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                )
            }
        }
    }
}

@Composable
fun ScheduleItem(schedule: Schedule, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    Card(modifier = modifier) {
        Column(
            modifier = Modifier.animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
            ) {
                ScheduleIcon(schedule.imageResourceId)
                ScheduleInformation(schedule.name, schedule.sks, schedule.room)
                Spacer(Modifier.weight(1f))
                ScheduleItemButton(expanded = expanded, onClick = { expanded = !expanded })
            }
            if (expanded) {
                ScheduleDetails(
                    schedule = schedule,
                    modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_small),
                        bottom = dimensionResource(R.dimen.padding_medium),
                        end = dimensionResource(R.dimen.padding_medium)
                    )
                )
            }
        }
    }
}

@Composable
private fun ScheduleItemButton(expanded: Boolean, onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = stringResource(R.string.expand_button_content_description),
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScheduleTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.image_size))
                        .padding(dimensionResource(R.dimen.padding_small)),
                    painter = painterResource(R.drawable.logo),
                    contentDescription = null
                )
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge.copy(fontSize = dimensionResource(R.dimen.font_size_display_large).value.sp)
                )
            }
        },
        modifier = modifier
    )
}

@Composable
fun ScheduleIcon(@DrawableRes scheduleIcon: Int, modifier: Modifier = Modifier) {
    Image(
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.small),
        contentScale = ContentScale.Crop,
        painter = painterResource(scheduleIcon),
        contentDescription = null
    )
}

@Composable
fun ScheduleInformation(@StringRes name: Int, sks: Int, room: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(name),
            style = MaterialTheme.typography.displayMedium.copy(
                fontSize = dimensionResource(R.dimen.font_size_display_medium).value.sp
            ),
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
        )
        Text(
            text = stringResource(R.string.total_sks, sks),
            style = MaterialTheme.typography.bodyLarge.copy(
                fontSize = dimensionResource(R.dimen.font_size_body_large).value.sp
            )
        )
    }
}

@SuppressLint("ResourceType")
@Composable
fun ScheduleDetails(schedule: Schedule, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = "Schedule Details", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(8.dp))

        // Get the subjects from the string array resource
        val subjects = stringArrayResource(schedule.timeArray)

        // Display each subject
        subjects.forEach { subject ->
            Text(text = subject, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Preview
@Composable
fun ThemeSchedulePreview() {
    MyScheduleTheme(darkTheme = false) {
        ScheduleApp()
    }
}

@Preview
@Composable
fun SchedulePreview() {
    MyScheduleTheme(darkTheme = true) {
        ScheduleApp()
    }
}

