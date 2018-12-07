package YOURPACKAGE;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

public class FlipAnimation {
    private int fromDrawable;
    private int toDrawable;

    private float scaleValueMin = 0f;
    private float scaleValueMax = 1f;

    private ObjectAnimator animatorToMin;
    private ObjectAnimator animatorToMax;

    /**
     * Given an {@code ImageView} and two {@code Drawable} resource IDs, allows the {@code ImageView}
     * to cycle seamlessly between the two images with a flipping animation.
     *
     * @param animationView  The {@code ImageView} to be animated.
     * @param fromDrawableID The resource ID for the starting {@code Drawable} resource.
     * @param toDrawableID   The resource ID for the end {@code Drawable} resource.
     */
    public FlipAnimation(final ImageView animationView, int fromDrawableID, int toDrawableID) {
        this.fromDrawable = fromDrawableID;
        this.toDrawable = toDrawableID;

        animatorToMin = ObjectAnimator.ofFloat(animationView, "scaleX", scaleValueMax, scaleValueMin);
        animatorToMin.setInterpolator(new DecelerateInterpolator());

        animatorToMax = ObjectAnimator.ofFloat(animationView, "scaleX", scaleValueMin, scaleValueMax);
        animatorToMax.setInterpolator(new AccelerateDecelerateInterpolator());

        animatorToMin.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                animationView.setImageResource(toDrawable);
                animatorToMax.start();
            }
        });
    }

    /**
     * Starts the initial, forward animation. Using this starts to animation from the
     * "from" {@code Drawable} to the "to" {@code Drawable}.
     */
    public void startAnimation() {
        animatorToMin.start();
    }

    /**
     * Starts the reverse animation. Using this starts to animation from the
     * "to" {@code Drawable} to the "from" {@code Drawable}.
     */
    public void reverseAnimation() {
        int temp = fromDrawable;
        fromDrawable = toDrawable;
        toDrawable = temp;

        startAnimation();
    }

}
