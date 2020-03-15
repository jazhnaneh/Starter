import { Injectable } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class AppValidation {
    constructor() { }

    
    /* String validation -------------------- */

    isNullOrEmpty(value: any): boolean {
        return (/^[\s]*$/.test(value));
    }

    isString(str: any): boolean {
        try {
            for (let i = 0; i < str.length; i++) {
                if (str[i] === ' ' || str[i] === '\n') {
                    continue;
                }

                if (!isNaN(str[i])) {
                    throw false;
                }
            }
            return true;
        } catch (e) {
            return false;
        }
    }

    isLen(str: string, len: number): boolean {
        return (str.length === len);
    }

    lenIsBetween(str: string, min: number, max: number): boolean {
        return (str.length >= min) && (str.length <= max);
    }

    /* Numeric validation -------------------- */

    isNumber(value: any): boolean {
        return (/^(([0-9]*)|(([0-9]*)\.([0-9]*)))$/.test(value));
    }

    lessThan(value: any, num: number, equal: boolean = false) {
        if (equal) {
            return (value <= num);
        } else {
            return (value < num);
        }
    }

    greatThan(value: any, num: number, equal: boolean = false) {
        if (equal) {
            return (value >= num);
        } else {
            return (value > num);
        }
    }

    isBetween(num: any, min: number, max: number): boolean {
        return (num >= min) && (num <= max);
    }

    /* Common validation -------------------- */

    isEmail(str: string): boolean {
        return (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(str));
    }

    isPhone(str: string): boolean {
        return (/^0[0-9]{10}$/.test(str));
    }

    isMobile(str: string): boolean {
        return (/^09[0-9]{9}$/.test(str));
    }

    isNationalNo(str: string): boolean {
        return (/^[0-9]{10}$/.test(str));
    }

    isDate(str: string): boolean {
        let currectStr = (/[0-9]{4}[/][0-9]{2}[/][0-9]{2}$/.test(str));
        if (!currectStr) {
            return false;
        } else {
            let part = str.split('/');
            let yy = this.isBetween(part[0], 1300, 1500);
            let mm = this.isBetween(part[1], 1, 12);
            let dd = this.isBetween(part[2], 1, 31);

            if (this.isBetween(part[1], 1, 6)) {
                dd = this.isBetween(part[2], 1, 31);
            }

            return (yy && mm && dd);
        }
    }

    /* Accounting validation -------------------- */

    isIBAN(str: string): boolean {
        return (/^[IR]{2}([0-9]{24})$/.test(str));
    }

    isCardNo(str: string): boolean {
        return (/^[0-9]{16}$/.test(str));
    }
}
