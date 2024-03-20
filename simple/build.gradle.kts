
import com.itoys.android.plugin.AppConfig
import java.text.SimpleDateFormat
import java.util.Date

plugins {
    alias(libs.plugins.itoys.android.application)
    alias(libs.plugins.itoys.android.hilt)
}

android {
    namespace = AppConfig.appId

    // 打包配置
    android.applicationVariants.all {
        this.outputs
            .map { it as com.android.build.gradle.internal.api.BaseVariantOutputImpl }
            .forEach { output ->
                val buildDate = SimpleDateFormat("yyyyMMddHHmm").format(Date())
                val outputFileName = "iToys_housing_${this.versionName}_${buildDate}_${this.buildType.name}_${AppConfig.patchVersion}.apk"
                output.outputFileName = outputFileName
            }
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.core.ktx)
    implementation(libs.material)
    implementation(libs.mmkv)

    // splash 模块
    implementation(projects.housingFeature.splash)
    // 合同模块
    implementation(projects.housingFeature.contract.implement)
    // 企业模块
    implementation(projects.housingFeature.enterprise.implement)
    // 房源
    implementation(projects.housingFeature.housing.implement)
    // 登录模块
    implementation(projects.housingFeature.login.export)
    implementation(projects.housingFeature.login.implement)
    // Main模块
    implementation(projects.housingFeature.main.implement)
    // 消息模块
    implementation(projects.housingFeature.message.implement)
    // 支付模块
    implementation(projects.housingFeature.pay.implement)

    implementation(projects.iToysCore.common)
    implementation(projects.iToysCore.location)
    implementation(projects.iToysCore.logcat)
    implementation(projects.iToysCore.network)
    implementation(projects.iToysCore.utils)
}