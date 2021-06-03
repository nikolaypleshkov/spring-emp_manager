import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Employee } from './employee';
import { EmployeeService } from './employee.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  employees: Employee[];
  editEmployee!: Employee;
  removeEmployee!: Employee;
  
 constructor(private employeeService: EmployeeService){
   this.employees = [];
 }

 ngOnInit(){
   this.getEmployees();
 }

 public getEmployees(): void{
   this.employeeService.getEmployees().subscribe(
     (response: Employee[]) =>{
       this.employees = response;
     },
     (error: HttpErrorResponse) => {
       alert(error.message);
       
     }
   );
 }

 public onOpenModal(employee: Employee, mode: string): void{
   const btn = document.createElement('button');
   btn.type = 'button';
   btn.style.display = 'none';

   btn.setAttribute('data-toggle', 'modal');

   if(mode === 'add'){
     btn.setAttribute('data-target', '#addEmployeeModal');
   }
   if(mode === 'edit'){
     this.editEmployee = employee;
    btn.setAttribute('data-target', '#updateEmployeeModal');
  }
  if(mode === 'delete'){
    this.removeEmployee = employee;
    btn.setAttribute('data-target', '#deleteEmployeeModal');
  }

  const container = document.getElementById('container-wrapp');
  container?.appendChild(btn);

  btn.click();
 }

 public addEmployee(addForm: NgForm){
   document.getElementById('add-employee-form')?.click();
   this.employeeService.addEmployees(addForm.value).subscribe(
     (response: Employee) => {
       console.log(response);
       this.getEmployees();

       addForm.reset();
     },
     (error: HttpErrorResponse) => {
       alert(error.message);
       addForm.reset();
    }
   );
 }

 public updateEmployee(employee: Employee): void{
  this.employeeService.updateEmployees(employee).subscribe(
    (response: Employee) => {
      console.log(response);
      this.getEmployees();
    },
    (error: HttpErrorResponse) => {
      alert(error.message)
   }
  );
}

public deleteEmployee(id: number): void{
  this.employeeService.deleteEmployees(id).subscribe(
    (response: void) => {
      console.log(response);
      this.getEmployees();
    },
    (error: HttpErrorResponse) => {
      alert(error.message)
   }
  );
}


}
