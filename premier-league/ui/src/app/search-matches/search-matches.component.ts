import { Component, OnInit } from '@angular/core';
import {DateAdapter, MAT_DATE_FORMATS, MatDateFormats, NativeDateAdapter} from "@angular/material/core";
import {FormControl} from "@angular/forms";
import {DatePipe} from "@angular/common";

@Component({
  selector: 'app-search-matches',
  templateUrl: './search-matches.component.html',
  styleUrls: ['./search-matches.component.css'],
})
export class SearchMatchesComponent implements OnInit{

  date = new FormControl(new Date());
  serializedDate = new FormControl((new Date()).getDate());



  minDate = new Date(1992, 7, 15);
  maxDate = new Date();

  constructor() { }

  ngOnInit(): void {

  }

}
