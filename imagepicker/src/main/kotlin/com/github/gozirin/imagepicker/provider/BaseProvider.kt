package com.github.gozirin.imagepicker.provider

import android.content.ContextWrapper
import android.os.Bundle
import android.os.Environment
import com.github.gozirin.imagepicker.ImagePickerActivity
import java.io.File

/**
 * Abstract Provider class
 *
 */
abstract class BaseProvider(protected val activity: ImagePickerActivity) :
    ContextWrapper(activity) {

    fun getFileDir(path: String?): File {
        return if (path != null) File(path)
        else getExternalFilesDir(Environment.DIRECTORY_DCIM) ?: activity.filesDir
    }

    /**
     * Cancel operation and Set Error Message
     *
     * @param error Error Message
     */
    protected fun setError(error: String) {
        onFailure()
        activity.setError(error)
    }

    /**
     * Cancel operation and Set Error Message
     *
     * @param errorRes Error Message
     */
    protected fun setError(errorRes: Int) {
        setError(getString(errorRes))
    }

    /**
     * Call this method when task is cancel in between the operation.
     * E.g. user hit back-press
     */
    protected fun setResultCancel() {
        onFailure()
        activity.setResultCancel()
    }

    /**
     * This method will be Call on Error, It can be used for clean up Tasks
     */
    protected open fun onFailure() {
    }

    /**
     * Save all appropriate provider state.
     */
    open fun onSaveInstanceState(outState: Bundle) {
    }

    /**
     * Restores the saved state for all Providers.
     *
     * @param savedInstanceState the Bundle returned by {@link #onSaveInstanceState()}
     * @see #onSaveInstanceState()
     */
    open fun onRestoreInstanceState(savedInstanceState: Bundle?) {
    }
}
