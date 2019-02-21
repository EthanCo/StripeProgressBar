## StripeProgressBar
Android 斜纹进度条，可自定义进度条图片。  

![StripeProgressBar.webp](StripeProgressBar.webp)

### 添加依赖
#### Step 1. Add the JitPack repository to your build file

	allprojects {
		repositories {
			...
			maven { url 'https://www.jitpack.io' }
		}
	}

#### Step 2. Add the dependency

	dependencies {
        implementation 'com.github.EthanCo:StripeProgressBar:v1.0.0'
	}

### 使用
在xml中添加

	 <com.heiko.stripeprogressbar.StripeProgressBar
        android:id="@+id/stripe_progress_bar"
        android:layout_gravity="center_horizontal"
        android:layout_width="200dp"
        app:progress_radius="10dp"
        app:progress_max="100"
        app:progress_background="@color/sp_progress_background"
        app:progress_image="@drawable/img_stripe_progress"
        android:layout_height="20dp"/>

在MainActivity中

	 StripeProgressBar stripeProgressBar = findViewById(R.id.stripe_progress_bar);
     stripeProgressBar.setProgress(XX);

#### 相关方法

	 /**
     * 设置进度条最大进度
     *
     * @param maxProgress
     */
    public void setMax(int maxProgress);

	 /**
     * 设置进度条当前进度
     *
     * @param progress
     */
    public void setProgress(int progress);

	 /**
     * 获取当前进度
     *
     * @return
     */
    public int getProgress();

#### 自定义属性

	<!--进度条圆角-->
    <attr name="progress_radius" format="dimension" />
    <!--进度条背景颜色-->
    <attr name="progress_background" format="color" />
    <!--进度条图片-->
    <attr name="progress_image" format="reference" />
    <!--进度条最大进度-->
    <attr name="progress_max" format="integer" />

