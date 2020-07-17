export class RoueDeLaVieModel {
  public client:number;
  public social1:number;
  public personnelle1:number;
  public sante1:number;
  public famille1:number;
  public professionnel1:number;
  public social2:number;
  public personnelle2:number;
  public sante2:number;
  public famille2:number;
  public professionnel2:number;
  public qcm1:string;
  public qcm2:string;
  public qcm3:string;
  constructor(qcm1:string,qcm2:string,qcm3:string){
    this.qcm1=qcm1;this.qcm2=qcm2;this.qcm3=qcm3
  }
}
