import { Injectable } from '@angular/core';
import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { environment } from '../../environments/environment';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }

  userList(): Observable<any> {
    let url = environment.baseUrl + '/student/getAll';
    return this.http.get(url);

  }

  addUser(user: User, file: File): Observable<HttpEvent<{}>> {
    const url = environment.baseUrl + '/student/addStudent';
    const formdata: FormData = new FormData();
    
    for ( var key in user ) {
      formdata.append(key, user[key]);
  }
    formdata.append('student_image', file);
    const req = new HttpRequest('POST', url, formdata);
    return this.http.request(req);

  }
}
