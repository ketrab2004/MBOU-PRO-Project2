package classes

class Room (val name: String, val description: String){

    var poiList: MutableList<POI> = mutableListOf() //mutable so it can be edited

}