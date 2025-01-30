import { HttpClient } from "@angular/common/http";
import { Component, inject } from "@angular/core";
import { UserType } from "../../models/user.model";
import { UserService } from "../../service/user.service";
import { RouterOutlet } from "@angular/router";


@Component({
    selector: 'page-user',
    imports: [RouterOutlet ],
    templateUrl: './user.Component.html',
    styleUrl: './user.Component.css'
})

export class UserPage {

    public userCollection: UserType[]= [];
     public isEditFormVisible = false;
     public selectedUser: UserType | null = null;
     public isCreateFormVisible = false;
     
    
     private userService = inject(UserService);
     
    
     private httpClient = inject(HttpClient)
    
     constructor(private http: HttpClient) {}
     
    
     public ngOnInit(): void {
      this.getAllUsers();
    
     }
     
      public getAllUsers() {
      this.userService.getAllUsers().subscribe((result: any) => {
        console.log(result);
        this.userCollection = result.data[0]; 
            console.log(this.userCollection); 
        },
        (error) => {
            console.error('Error fetching users:', error);
    
        })
    
       }
    
       public processOnCreate() {
    
        this.isCreateFormVisible = true;
        this.selectedUser = null;
    
       }
    
    public processOnCreateUser($inputValue:string) {
    
      this.userService.createNewUser({ userName: $inputValue 
    
      }).subscribe((result: any) => {
    
        console.log(result);
        this.getAllUsers();
    
      });
      
    }
    
    public processOnEdit($selectedUser: UserType) {
    
      this.isEditFormVisible = true;
      this.selectedUser      = $selectedUser;
    
    }
    
    public processOnSave() {
    
      this.userService.updateUser(this.selectedUser!).subscribe((result) =>{
    
        console.log(result);
    
      });
    
    }
    
    public processOnChangeUserName($userInput: string) {
    
      if(this.selectedUser) {
        this.selectedUser.userName = $userInput;
    
      }
    }
    
    public processOnDelete($selectedUser: UserType) {
    
      this.userService.removeUser($selectedUser.id!).subscribe((result: any) =>{
        this.getAllUsers();
    
      });
    
    
    }
    


}