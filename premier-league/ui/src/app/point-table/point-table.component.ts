import {Component, OnInit, ViewChild} from '@angular/core';
import { FormControl } from '@angular/forms';
import {MatTableDataSource} from '@angular/material/table';
import {PointTableService} from "./point-table.service";
import {MatSort, Sort} from "@angular/material/sort";

@Component({
  selector: 'app-point-table',
  templateUrl: './point-table.component.html',
  styleUrls: ['./point-table.component.css']
})
export class PointTableComponent implements OnInit {

  displayedColumns: string[] = ['club', 'points', 'wins', 'looses', 'draws', 'goals_scored', 'goals_received'];
  dataSource: MatTableDataSource<PointTable>
  disableSelect = new FormControl(false);

  constructor(private tableService: PointTableService ) { }

  @ViewChild(MatSort) sort: MatSort;

  selectedColumn = 'points';

  ngOnInit(): void {
    this.dataSource = new MatTableDataSource<PointTable>();

    this.tableService.getClubs().subscribe((data) => {
      this.dataSource = new MatTableDataSource<PointTable>(data['response']);
      this.dataSource.sort = this.sort;
      this.changeSortedColumn();
    })
  }

  changeSortedColumn() {
    const sortState: Sort = {active: this.selectedColumn, direction: 'desc'};
    this.sort.active = sortState.active;
    this.sort.direction = sortState.direction;
    this.sort.sortChange.emit(sortState);
  }

}

export interface PointTable {
  clubName: string;
  points: number;
  wins: number;
  defeats: number;
  draws: number;
  goalsScored: number;
  goalsReceived: number;
}

