package org.crux.spatial

interface Location1D<TYPE : Number> : OneDimensional {
    var x: TYPE
}

interface Location2D<TYPE : Number> : Location1D<TYPE>, TwoDimensional {
    var y: TYPE
}

interface Location3D<TYPE : Number> : Location2D<TYPE>, ThreeDimensional {
    var z: TYPE
}