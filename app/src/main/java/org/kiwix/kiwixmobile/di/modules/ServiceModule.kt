package org.kiwix.kiwixmobile.di.modules

import dagger.Module
import dagger.Provides
import org.kiwix.kiwixlib.JNIKiwixLibrary
import org.kiwix.kiwixlib.JNIKiwixServer
import org.kiwix.kiwixmobile.webserver.WebServerHelper
import javax.inject.Singleton

@Module
class ServiceModule {

  @Provides
  @Singleton
  fun providesWebServerHelper(): WebServerHelper {
    return WebServerHelper(
      providesJNIKiwixLibrary(),
      providesJNIKiwixServer(providesJNIKiwixLibrary())
    )
  }

  @Provides
  @Singleton
  fun providesJNIKiwixLibrary(): JNIKiwixLibrary {
    return JNIKiwixLibrary()
  }

  @Provides
  @Singleton
  fun providesJNIKiwixServer(jniKiwixLibrary: JNIKiwixLibrary): JNIKiwixServer {
    return JNIKiwixServer(jniKiwixLibrary)
  }
}