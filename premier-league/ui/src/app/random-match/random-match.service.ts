import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {map} from "rxjs/operators";

@Injectable()
export class RandomMatchService {
  private randomMatchUrl = '/randomMatch';

  constructor(private http: HttpClient) {}

  public getRandomMatch(): any{
    return this.http.get(this.randomMatchUrl);
  }
}
