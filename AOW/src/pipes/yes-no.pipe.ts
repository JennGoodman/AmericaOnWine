import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'yesNo'
})
export class YesNoPipe implements PipeTransform {

  transform(value: string): string {
    if (value.toLowerCase() === 'true') {
      return 'Yes';
    } else if (value.toLowerCase() === 'false') {
      return 'No';
    } else {
      return 'Not a boolean';
    }
  }

}
