import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class AllPlayedMatchesService {
  private listMatchesUrl = '/listOfMatches';

  constructor(private http: HttpClient) {}

  public getMatches(): any{
    return this.http.get(this.listMatchesUrl)
  }
}
