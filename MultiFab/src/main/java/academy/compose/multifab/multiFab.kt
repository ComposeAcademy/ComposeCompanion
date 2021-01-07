package academy.compose.multifab

import androidx.compose.animation.animate
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ExpandingFab(
    fabIcon: ImageBitmap,
    items: List<MultiFabItem>,
    toState: MultiFabState,
    stateChanged: (fabstate: MultiFabState) -> Unit,
    onFabItemClicked: (item: MultiFabItem) -> Unit
) {
    val transition: Transition<MultiFabState> = updateTransition(targetState = toState)
    val scale: Float by transition.animateFloat { state ->
        if (state == MultiFabState.EXPANDED) 56f else 0f
    }
    val alpha: Float by transition.animateFloat(
        transitionSpec = {
            tween(durationMillis = 50)
        }
    ) { state ->
        if (state == MultiFabState.EXPANDED) 1f else 0f
    }
    val shadow: Dp by transition.animateDp(
        transitionSpec = {
            tween(durationMillis = 50, delayMillis = 500)
        }
    ) { state ->
        if (state == MultiFabState.EXPANDED) 2.dp else 0.dp
    }
    val rotation: Float by transition.animateFloat { state ->
        if (state == MultiFabState.EXPANDED) 45f else 0f
    }
    Column(horizontalAlignment = Alignment.End) {
        val fabColor = MaterialTheme.colors.secondary
        items.forEach { item ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(end = 12.dp)
            ) {
                Text(
                    item.label,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.alpha(animate(target = alpha))
                        .shadow(animate(target = shadow))
                        .background(color = MaterialTheme.colors.surface)
                        .padding(start = 6.dp, end = 6.dp, top = 4.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Canvas(
                    modifier = Modifier.size(32.dp)
                        .clickable(
                            onClick = { onFabItemClicked(item) },
                            indication = rememberRipple(
                                bounded = false,
                                radius = 20.dp,
                                color = MaterialTheme.colors.onSecondary
                            )
                        )
                ) {
                    drawCircle(
                        Color(android.graphics.Color.parseColor("#1F000000")),
                        center = Offset(this.center.x + 2f, this.center.y + 7f),
                        radius = scale
                    )
                    drawCircle(color = fabColor, scale)
                    drawImage(
                        item.icon,
                        topLeft = Offset(
                            (this.center.x) - (item.icon.width / 2),
                            (this.center.y) - (item.icon.width / 2)
                        ),
                        alpha = alpha
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
        FloatingActionButton(onClick = {
            stateChanged(
                if (transition.currentState == MultiFabState.EXPANDED) {
                    MultiFabState.COLLAPSED
                } else MultiFabState.EXPANDED
            )
        }) {
            Icon(
                bitmap = fabIcon,
                modifier = Modifier.rotate(rotation)
            )
        }
    }
}