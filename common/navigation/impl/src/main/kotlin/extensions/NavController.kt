package extensions

import android.util.Log
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.Navigator

fun NavHostController.safeNavigate(
    navController: NavHostController,
    route: String,
    navOptions: NavOptions? = null,
    navigatorExtras: Navigator.Extras? = null
) {
    val currentRoute = navController.currentBackStackEntry?.destination?.route
    if (currentRoute == route) return

    if (this.graph.findNodeInGraph(route) != null) {
        navigate(route, navOptions, navigatorExtras)
    } else {
        Log.e("SafeNavigate exception", "Route $route not found in the navigation graph.")
    }
}

private fun NavGraph.findNodeInGraph(route: String): NavDestination? {
    val nodesQueue = ArrayDeque<NavDestination>()
    nodesQueue.add(this)
    while (nodesQueue.isNotEmpty()) {
        val currentNode = nodesQueue.removeFirst()
        if (currentNode.route == route) return currentNode
        if (currentNode is NavGraph) nodesQueue.addAll(currentNode)
    }
    return null
}