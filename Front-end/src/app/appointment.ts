export class User{
    userId:number; 
    userPassword:string;
    userName:string;
    contactNo:string;
    usreRole:string;
    emailId:string;
}
export class Test{
    testId:number;
    testName:string;
}
export class DiagnosticCenter{
    centerId:number;
    centerName:string;
    test:Test[];
}
export class Appointment{
    center:DiagnosticCenter;
    appointmentId:number;
    test:Test;
    user:User;
    datetime:Date;
    approved:boolean;
}