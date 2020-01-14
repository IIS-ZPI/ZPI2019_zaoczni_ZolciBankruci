import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SessionCounterComponent } from './components/session-counter/session-counter.component';
import { MenuComponent } from './components/menu/menu.component';
import { StatisticalMeasureComponent } from './components/statistical-measure/statistical-measure.component';
import { ChangesOverTimeComponent } from './components/changes-over-time/changes-over-time.component';

@NgModule({
  declarations: [
    AppComponent,
    SessionCounterComponent,
    MenuComponent,
    StatisticalMeasureComponent,
    ChangesOverTimeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
