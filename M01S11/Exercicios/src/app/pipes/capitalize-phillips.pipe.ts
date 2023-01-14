import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'capitalizePhillips'
})
export class CapitalizePhillipsPipe implements PipeTransform {
  transform(text: string): string {

    let textToTransform: string | string[] = text

    textToTransform = textToTransform.split(' ')

    textToTransform = textToTransform.map(word => {
      if (word) {
        return word[0].toUpperCase() + word.slice(1)
      }
      return ''
    })

    textToTransform = textToTransform.join(' ')

    return textToTransform
  }
}
