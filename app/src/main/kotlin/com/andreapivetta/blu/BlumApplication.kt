package com.andreapivetta.blu

import android.app.Application
import com.andreapivetta.blu.common.pref.AppSettingsImpl
import com.andreapivetta.blu.data.db.AppStorageImpl
import com.andreapivetta.blu.data.jobs.NotificationsJobCreator
import com.andreapivetta.blu.data.twitter.TwitterUtils
import com.evernote.android.job.JobManager

/**
 * Created by andrea on 18/05/16.
 */
open class BlumApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AppSettingsImpl.init(applicationContext)
        TwitterUtils.init()
        AppStorageImpl.init(applicationContext)
        JobManager.create(this).addJobCreator(NotificationsJobCreator())
    }

}