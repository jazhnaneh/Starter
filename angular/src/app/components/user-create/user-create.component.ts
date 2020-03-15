import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { User } from '../../models/user';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-create',
  templateUrl: './user-create.component.html',
  styleUrls: ['./user-create.component.css'],
  providers: [UserService, ToastrService]
})
export class UserCreateComponent implements OnInit {

  user: User = new User();
  selectedFiles: FileList;
  studentImage: File;
  constructor(private userListService: UserService, private toastr: ToastrService, private router: Router) { }

  selectFile(event) {
    this.selectedFiles = event.target.files;
  }

  addUser() {
    this.studentImage = this.selectedFiles.item(0);
    this.userListService.addUser(this.user, this.studentImage).subscribe(
      res => {
        this.toastr.success('اطلاعات با موفقیت ثبت شد');
        this.router.navigate(['/userList']);
      },
    );
  }

  ngOnInit() {
  }

}
