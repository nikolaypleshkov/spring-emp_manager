import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient } from '@angular/common/http';
import { Employee } from "./employee";
import { environment } from "src/environments/environment";

@Injectable({
    providedIn: 'root'
})
export class EmployeeService{
    private apiServerURL = environment.apiBaseUrl;

    constructor(private http: HttpClient){}

    public getEmployees(): Observable<Employee[]>{
        return this.http.get<Employee[]>(`${this.apiServerURL}/employee/all`);
    }

    public addEmployees(employee: Employee): Observable<Employee>{
        return this.http.post<Employee>(`${this.apiServerURL}/employee/add`, employee);
    }

    public updateEmployees(employee: Employee): Observable<Employee>{
        return this.http.put<Employee>(`${this.apiServerURL}/employee/update`, employee);
    }

    
    public deleteEmployees(employeeId: number): Observable<void>{
        return this.http.delete<void>(`${this.apiServerURL}/employee/delete/${employeeId}`);
    }
    
}