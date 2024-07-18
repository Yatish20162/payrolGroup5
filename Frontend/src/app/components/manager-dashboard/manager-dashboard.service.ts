import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { LeaveRequest } from '../../model/Leave-Request.model';
import {NotificationResponse} from '../../model/notification-response'
@Injectable({
  providedIn: 'root'
})
export class ManagerDashboardService {
  private apiUrl = 'http://localhost:8000/leave';

  constructor(private http: HttpClient) {}

  getLeaveRequestCount(employeeId: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/viewLeaves?employeeId=${employeeId}`).pipe(
      catchError((error) => {
        console.error('Error fetching leave request count:', error);
        return throwError(error);
      })
    );
  }

  fetchLeaveRequests(managerId: number): Observable<any> {
     console.log("URL-->" , this.http.get<any>(`${this.apiUrl}/fetchleaverequest?managerId=${managerId}`));
   return this.http.get<any>(`${this.apiUrl}/fetchleaverequest?managerId=${managerId}`);
  }

  approveLeave(notificationResponseDto: NotificationResponse): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/approveleave`, notificationResponseDto);
  }
}