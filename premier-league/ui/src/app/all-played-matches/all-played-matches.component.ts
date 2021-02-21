import { Component, OnInit } from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {AllPlayedMatchesService} from "./all-played-matches.service";

export interface AllMatches {
  team1: string;
  team2: string;
  team1Score: number;
  team2Score: number;
  date: string;
}

@Component({
  selector: 'app-all-played-matches',
  templateUrl: './all-played-matches.component.html',
  styleUrls: ['./all-played-matches.component.css']
})
export class AllPlayedMatchesComponent implements OnInit {

  displayedColumns: string[] = ['club_1', 'club_2', 'club_1_score', 'club_2_score', 'date'];
  dataSource = new MatTableDataSource<AllMatches>();
  columns: string[];

  constructor(private tableService: AllPlayedMatchesService) { }

  ngOnInit(): void {
    this.tableService.getMatches().subscribe((data) => {
      this.dataSource = new MatTableDataSource<AllMatches>(data['response']);
      this.columns = data['response'].date;

      this.dataSource.filterPredicate = function(row: any, filter: string): boolean {
        return row.date.includes(filter);
      };
    })


  }

  applyFilter(filterValue: string) {
    /*filterValue = (event.target as HTMLInputElement).value;
    filterValue = filterValue.trim().toLowerCase();
    this.dataSource.filter = filterValue;*/

    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // MatTableDataSource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }

}


