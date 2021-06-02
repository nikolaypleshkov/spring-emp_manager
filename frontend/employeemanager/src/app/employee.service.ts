import { Observable } from "rxjs";

export class EmployeeService{
    private apiServerURL = '';

    constructor(private http: HttpClient){}

    public getEmployees(): Observable<any>{
        return this.http.get<any>(`${this.apiServerURL}/employee/all`);
    }
}