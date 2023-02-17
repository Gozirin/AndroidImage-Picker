package com.github.gozirin.imagepicker.listener

/**
 * Interface used to allow the creator of a dialog to run some code when the
 * dialog is dismissed.
 *
 */
interface DismissListener {

    /**
     * This method will be invoked when the dialog is dismissed.
     */
    fun onDismiss()
}
