import { TestBed } from "@angular/core/testing";
import { NotificationService } from "./notification.service";
import { HttpClient } from "@angular/common/http";
import { HttpClientTestingModule, HttpTestingController } from "@angular/common/http/testing";
import { NOTIFICATIONS_MOCK } from "../utils/notifications-mock";

describe('NotificationService', () => {
	let httpTestingController: HttpTestingController;
	let notificationService: NotificationService;
	let httpClient: HttpClient;

	beforeEach(async () => {
		await TestBed.configureTestingModule({
			imports: [ HttpClientTestingModule ],
			providers: [ NotificationService ],
		}).compileComponents();

		httpTestingController = TestBed.inject(HttpTestingController);
		httpClient = TestBed.inject(HttpClient);
		notificationService = TestBed.inject(NotificationService);
	});

	it('Should create service component', () => {
		expect(notificationService).toBeTruthy();
	})


	it('getNotification - should return a list of notifications with success', () => {
		notificationService.getNotifications().subscribe(
			retorno => {
				expect(retorno).toEqual(NOTIFICATIONS_MOCK);
			}
		);
	});

	it('getNotificationsApi - should be called with success with GET method', () => {
		notificationService.getNotificationsApi().subscribe();

		const result = httpTestingController.expectOne(`${notificationService.BASE_URL}`);

		expect(result.request.method).toEqual('GET');
	});

	it('addNotificationApi - should add an object with success', () => {
		const notification = 'notification';
		notificationService.addNotificationApi(notification).subscribe();

		const result = httpTestingController.expectOne(`${notificationService.BASE_URL}`);

		expect(result.request.method).toEqual('POST');
		expect(result.request.body).toEqual(notification);
	});

	it('editNotificationApi - should update values with success with PUT method', () => {
		const notification = {id: 1, titulo: 'notificação'};
		notificationService.editNotificationApi(notification).subscribe();

		const result = httpTestingController.expectOne(`${notificationService.BASE_URL}/${notification.id}`);

		expect(result.request.method).toEqual('PUT');
		expect(result.request.body).toEqual(notification);
	});

	it('removeNotification - should remove data with success with DELETE method', () => {
		const notification = {id: 1, titulo: 'notificação'};
		notificationService.removeNotification(notification.id).subscribe();

		const resultado = httpTestingController.expectOne(`${notificationService.BASE_URL}/${notification.id}`);
		expect(resultado.request.method).toEqual('DELETE');
	});
});