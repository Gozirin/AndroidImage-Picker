package com.github.gozirin.imagepicker.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.github.gozirin.imagepicker.R
import com.github.gozirin.imagepicker.constant.ImageProvider
import com.github.gozirin.imagepicker.listener.DismissListener
import com.github.gozirin.imagepicker.listener.ResultListener

/**
 * Show Dialog
 *
 */
internal object DialogHelper {

    /**
     * Show Image Provide Picker Dialog. This will streamline the code to pick/capture image
     *
     */
    fun showChooseAppDialog(
        context: Context,
        listener: ResultListener<ImageProvider>,
        dismissListener: DismissListener?
    ) {
        val layoutInflater = LayoutInflater.from(context)
        val customView = layoutInflater.inflate(R.layout.dialog_choose_app, null)

        val dialog = AlertDialog.Builder(context)
            .setTitle(R.string.title_choose_image_provider)
            .setView(customView)
            .setOnCancelListener {
                listener.onResult(null)
            }
            .setNegativeButton(R.string.action_cancel) { _, _ ->
                listener.onResult(null)
            }
            .setOnDismissListener {
                dismissListener?.onDismiss()
            }
            .show()

        // Handle Camera option click
        customView.findViewById<View>(R.id.lytCameraPick).setOnClickListener {
            listener.onResult(ImageProvider.CAMERA)
            dialog.dismiss()
        }

        // Handle Gallery option click
        customView.findViewById<View>(R.id.lytGalleryPick).setOnClickListener {
            listener.onResult(ImageProvider.GALLERY)
            dialog.dismiss()
        }
    }
}
