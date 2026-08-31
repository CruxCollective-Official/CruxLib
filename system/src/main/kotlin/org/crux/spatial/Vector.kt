package org.crux.spatial

interface Vector1D<TYPE : Number> : OneDimensional

interface Vector2D<TYPE : Number> : Vector1D<TYPE>, TwoDimensional {
    var yaw: TYPE
}

interface Vector3D<TYPE : Number> : Vector2D<TYPE>, ThreeDimensional {
    var pitch: TYPE
}