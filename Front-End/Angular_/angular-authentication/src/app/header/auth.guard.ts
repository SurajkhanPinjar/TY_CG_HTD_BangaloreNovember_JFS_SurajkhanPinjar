import { CanActivate, ActivatedRouteSnapshot } from '@angular/router';

export class AuthGuard implements CanActivate {

    canActivate(route: ActivatedRouteSnapshot): boolean {
        let expectedRolesArray = route.data.expectedRoles;
        let userDetails = JSON.parse(localStorage.getItem('userDetails'));
        let expectedRole: string;
        for (let index in expectedRolesArray ) {
            if (userDetails && userDetails.account['0'].role === expectedRolesArray[index]) {
                expectedRole = expectedRolesArray[index];
            }
        }
        if (userDetails && userDetails.account['0'].role === expectedRole) {
            return true;
        } else {
            return false;   
        }
     }
}
