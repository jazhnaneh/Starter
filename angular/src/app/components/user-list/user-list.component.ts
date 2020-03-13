import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { User } from '../../models/user';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css'],
  providers: [UserService]
})
export class UserListComponent implements OnInit {
  userlist: User[];
  constructor(private userService: UserService) { }

  getUserList() {
    this.userService.userList().subscribe(
      res => {
       this.userlist=res;

      },
    );
  }

  ngOnInit() {
    this.getUserList();
  }

}
