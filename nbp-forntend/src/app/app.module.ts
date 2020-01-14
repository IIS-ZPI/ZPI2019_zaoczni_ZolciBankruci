import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SessionCounterComponent } from './components/session-counter/session-counter.component';
import { MenuComponent } from './components/menu/menu.component';
import { StatisticalMeasureComponent } from './components/statistical-measure/statistical-measure.component';
import { ChangesOverTimeComponent } from './components/changes-over-time/changes-over-time.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

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
    AppRoutingModule,
    NgModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
