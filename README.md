FlipAnimation was created specifically to achieve the following animation effect: 

![Animation preview](animationpreview.gif)


### Usage: ###

To instantiate the class, merely pass the desired ImageView to animate, and the two Resource IDs:
```
FlipAnimation animation = new FlipAnimation(ImageView, R.drawable.fromDrawable, R.drawable.toDrawable);
```

Now to start the forward animation:
```
animation.startAnimation();
```

To reverse the animation:
```
animation.reverseAnimation();
```
