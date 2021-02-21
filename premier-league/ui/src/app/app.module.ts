import { HomeComponent } from './home/home.component';
import { MaterialModule } from './material/material.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { PointTableComponent } from './point-table/point-table.component';
import { SearchMatchesComponent } from './search-matches/search-matches.component';
import { RandomMatchComponent } from './random-match/random-match.component';
import { RandomPopUpComponent } from './random-pop-up/random-pop-up.component';
import { AllPlayedMatchesComponent } from './all-played-matches/all-played-matches.component';


import {HTTP_INTERCEPTORS, HttpClientModule, HttpClientXsrfModule} from "@angular/common/http";
import { AppHttpInterceptorService } from './point-table/http-interceptor.service';
import {PointTableService} from "./point-table/point-table.service";
import {AllPlayedMatchesService} from "./all-played-matches/all-played-matches.service";
import {RandomMatchService} from "./random-match/random-match.service";
import {ReactiveFormsModule} from "@angular/forms";
import {MatSortModule} from "@angular/material/sort";
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    PointTableComponent,
    SearchMatchesComponent,
    RandomMatchComponent,
    RandomPopUpComponent,
    AllPlayedMatchesComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        BrowserAnimationsModule,
        MaterialModule,
        HttpClientModule,
        HttpClientXsrfModule.withOptions({
            cookieName: 'Csrf-Token',
            headerName: 'Csrf-Token',
        }),
        ReactiveFormsModule,
        MatSortModule,
        FormsModule,
        MatFormFieldModule
    ],
  providers: [
    PointTableService,
    {
      multi: true,
      provide: HTTP_INTERCEPTORS,
      useClass: AppHttpInterceptorService
    },
    AllPlayedMatchesService,
    {
      multi: true,
      provide: HTTP_INTERCEPTORS,
      useClass: AppHttpInterceptorService
    },
    RandomMatchService,
    {
      multi: true,
      provide: HTTP_INTERCEPTORS,
      useClass: AppHttpInterceptorService
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
