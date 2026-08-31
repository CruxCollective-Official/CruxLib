package org.crux.spatial

interface Rotation1D<TYPE : Number> : OneDimensional

interface Rotation2D<TYPE : Number> : Rotation1D<TYPE>, TwoDimensional {
    var yaw: TYPE
}

interface Rotation3D<TYPE : Number> : Rotation2D<TYPE>, ThreeDimensional {
    var pitch: TYPE
    var roll: TYPE
}