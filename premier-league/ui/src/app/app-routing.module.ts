import { AllPlayedMatchesComponent } from './all-played-matches/all-played-matches.component';
import { RandomMatchComponent } from './random-match/random-match.component';
import { HomeComponent } from './home/home.component';
import { SearchMatchesComponent } from './search-matches/search-matches.component';
import { PointTableComponent } from './point-table/point-table.component';
import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {path: '', component: HomeComponent, outlet: 'outlet'},
  {path: 'home', component: HomeComponent, outlet: 'outlet'},
  {path: 'pointTable', component: PointTableComponent, outlet: 'outlet'},
  {path: 'search', component: SearchMatchesComponent, outlet: 'outlet'},
  {path: 'random', component: RandomMatchComponent, outlet: 'outlet'},
  {path: 'allMatches', component: AllPlayedMatchesComponent, outlet: 'outlet'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
