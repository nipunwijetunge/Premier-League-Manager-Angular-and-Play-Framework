import {RandomPopUpComponent} from './../random-pop-up/random-pop-up.component';
import { Component, OnInit } from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import {RandomMatchService} from "./random-match.service";

@Component({
  selector: 'app-random-match',
  templateUrl: './random-match.component.html',
  styleUrls: ['./random-match.component.css']
})
export class RandomMatchComponent implements OnInit {

  team1: string;
  team2: string;
  team1Score: number;
  team2Score: number;
  date: string;

  constructor(private readonly dialog: MatDialog, private randomMatch: RandomMatchService) { }

  ngOnInit(): void { }

  openDialog() {
    this.randomMatch.getRandomMatch().subscribe((data) => {

      this.team1 = data['response'].team1.toString();
      this.team2 = data['response'].team2.toString();
      this.team1Score = data['response'].team1Score.toString();
      this.team2Score = data['response'].team2Score.toString();
      this.date = data['response'].date.toString();

      this.dialog.open(RandomPopUpComponent, {data:{
          randomMatch:{
            team1: this.team1,
            team2: this.team2,
            team1Score: this.team1Score,
            team2Score: this.team2Score,
            date: this.date
          }
        }
      });
    })
  }
}
