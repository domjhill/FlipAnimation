FlipAnimation was created for two reasons:
1) To achieve the following animation effect: 
![Animation preview](animationpreview.gif)

2) To only use a single ImageView, and not layer two or more on top of each other.


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
