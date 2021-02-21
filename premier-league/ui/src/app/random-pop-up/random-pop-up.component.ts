import {Component, Inject, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {MAT_DIALOG_DATA, MatDialogContent} from "@angular/material/dialog";
import {MatTableDataSource} from "@angular/material/table";
import {RandomMatchComponent} from "../random-match/random-match.component";

@Component({
  selector: 'app-random-pop-up',
  templateUrl: './random-pop-up.component.html',
  styleUrls: ['./random-pop-up.component.css']
})
export class RandomPopUpComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit(): void { }

}
