import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'formataCpf',
})
export class FormataCpf implements PipeTransform {
  transform(value: string, ocultaNumeros: boolean = false): string {
    value = value.padEnd(11, '0').substring(0, 11);

    if (ocultaNumeros) {
      return value.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/, 'XXX.$2.$3-XX');
    }
    return value.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/, '$1.$2.$3-$4');
  }
}
