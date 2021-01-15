package academy.compose.sample

import academy.compose.multifab.MultiFabItem
import academy.compose.multifab.MultiFabState
import academy.compose.multifab.MultiFloatingActionButton
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import academy.compose.sample.ui.ComposeCompanionTheme
import androidx.compose.animation.core.animateAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.AmbientContext
import androidx.compose.ui.res.imageResource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCompanionTheme {
                var toState by remember { mutableStateOf(MultiFabState.COLLAPSED) }
                Scaffold(
                    floatingActionButton = {
                        MultiFloatingActionButton(
                            imageResource(id = R.drawable.plus),
                            listOf(
                                MultiFabItem(
                                    "new",
                                    imageResource(id = R.drawable.plus), "New item"
                                ),
                                MultiFabItem(
                                    "existing",
                                    imageResource(id = R.drawable.plus), "Owned item"
                                )
                            ), toState, true, { state ->
                                toState = state
                            }
                        ) {

                        }
                    }
                ) {
                    val alpha = if (toState == MultiFabState.EXPANDED) 0.4f else 0f
                    Box(
                        modifier = Modifier.alpha(animateAsState(alpha).value).background(
                            Color(AmbientContext.current.resources.getColor(R.color.transparent_black))
                        ).fillMaxSize()
                    )
                }
            }
        }
    }
}