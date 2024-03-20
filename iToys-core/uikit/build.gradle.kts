plugins {
    alias(libs.plugins.itoys.android.library)
}

android {
    namespace = "com.itoys.android.uikit"
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.core.ktx)
    implementation(libs.material)
    implementation(libs.brv)
    implementation(libs.constraint.layout)
    implementation(libs.calendar.angcyo)
    implementation(libs.immersionbar)
    implementation(libs.lottie)
    implementation(libs.magic.indicator)
    implementation(libs.picker.wheel)
    implementation(libs.title.bar)
    implementation(libs.viewpager2)
    implementation(libs.wheel)

    implementation(projects.iToysCore.image)
    implementation(projects.iToysCore.logcat)
    implementation(projects.iToysCore.utils)
}