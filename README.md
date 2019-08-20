## Custom App Onboarding
Custom Android App Onboarding Sample using PagerTransformer. [Kotlin]
> [![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg?style=flat-square)](https://github.com/p1yu5h/CustomOnboarding/pulls)
> [![GitHub stars](https://img.shields.io/github/stars/p1yu5h/CustomOnboarding)](https://github.com/p1yu5h/CustomOnboarding/stargazers)
> [![GitHub forks](https://img.shields.io/github/forks/p1yu5h/CustomOnboarding)](https://github.com/p1yu5h/CustomOnboarding/network/members)
> [![HitCount](http://hits.dwyl.io/p1yu5h/CustomOnboarding.svg)](http://hits.dwyl.io/p1yu5h/CustomOnboarding)


## Preview
<img src="https://github.com/p1yu5h/CustomOnboarding/blob/master/custom_onboarding_sample.gif" width="260" height="500" />

## CustomPageTransformer
<pre>
class <b>CustomPageTransformer</b> : ViewPager.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        val pageWidth = page.width
        val pageHeight = page.height
        val imgTop : ImageView = page.findViewById(R.id.top_image)
        val imgBottom : ImageView = page.findViewById(R.id.bottom_image)

        if (position <= -1.0f || position >= 1.0f) {
            imgTop.translationX = pageWidth * position
            imgTop.alpha = 0.0f
            imgBottom.translationX = pageWidth * position
            imgBottom.alpha = 0.0f
        } else if (position == 0.0f) {
            imgTop.translationX = pageWidth * position
            imgTop.alpha = 1.0f
            imgBottom.translationX = pageWidth * position
            imgBottom.alpha = 1.0f
        } else {
            <b>// position is between -1.0f & 0.0f OR 0.0f & 1.0f</b>
            imgTop.translationX = -position * pageWidth
            imgTop.translationY = position * pageHeight
            imgTop.alpha = 1.0f - 5 * abs(position)

            imgBottom.translationX = -position * pageWidth
            imgBottom.translationY = -position * pageHeight
            imgBottom.alpha = 1.0f - 5 * abs(position)
        }
    }
}
</pre>
## Using CustomPageTransformer
<pre>
        val viewPager : ViewPager = findViewById(R.id.viewpager)
        viewPager.adapter = PageAdapter(supportFragmentManager)
       <b> viewPager.setPageTransformer(/*reversDrawingOrder*/ true, CustomPageTransformer())</b>
</pre>

#### Open-Source Illustrations From: [unDraw](https://undraw.co) | [License](https://undraw.co/license) 
