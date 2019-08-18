package org.kiwix.kiwixmobile.di.components

import android.app.Service
import dagger.BindsInstance
import dagger.Subcomponent
import org.kiwix.kiwixmobile.di.modules.ServiceModule
import org.kiwix.kiwixmobile.wifi_hotspot.HotspotService
import javax.inject.Scope

@Subcomponent(modules = [ServiceModule::class])
@Scope interface ServiceComponent {
  fun inject(hotspotService: HotspotService)

  @Subcomponent.Builder
  interface Builder {

    @BindsInstance fun service(service: Service): Builder

    fun build(): ServiceComponent
  }
}