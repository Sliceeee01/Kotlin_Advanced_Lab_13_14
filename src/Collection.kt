val rockPlanets = arrayOf<String>("Mercury", "Venus", "Earth", "Mars")

val gasPlanets = arrayOf("Jupiter", "Saturn", "Uranus", "Neptune")

val solarSystem = rockPlanets + gasPlanets

val newSolarSystem = arrayOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto")

fun main() {
    println(newSolarSystem[8])
}