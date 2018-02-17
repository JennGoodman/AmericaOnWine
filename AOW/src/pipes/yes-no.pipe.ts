import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'yesNo'
})
export class YesNoPipe implements PipeTransform {

  transform(value: number): string {
    if (value === 1) {
      return 'Yes';
    } else if (value === 0) {
      return 'No';
    } else {
      return 'Invalid status';
    }
  }

}
