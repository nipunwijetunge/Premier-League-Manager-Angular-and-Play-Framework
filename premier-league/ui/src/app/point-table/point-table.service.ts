import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class PointTableService {
  private listClubsUrl = '/listOfClubs';

  constructor(private http: HttpClient) {}

  public getClubs(): any{
    return this.http.get(this.listClubsUrl)
  }
}
