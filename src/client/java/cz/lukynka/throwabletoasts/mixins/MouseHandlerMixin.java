package cz.lukynka.throwabletoasts.mixins;

import com.mojang.blaze3d.platform.InputConstants;
import cz.lukynka.throwabletoasts.client.ThrowableToastsClient;
import net.minecraft.client.MouseHandler;
import net.minecraft.client.input.MouseButtonInfo;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MouseHandler.class)
public class MouseHandlerMixin {

    @Inject(at = @At("HEAD"), method = "onButton")
    private void onPress(long l, MouseButtonInfo rawButtonInfo, int i, CallbackInfo ci) {
        if (rawButtonInfo.button() != InputConstants.MOUSE_BUTTON_LEFT) return;

        if (i == 1) {
            ThrowableToastsClient.onMouseDown();
        } else {
            ThrowableToastsClient.onMouseUp();
        }
    }
}
