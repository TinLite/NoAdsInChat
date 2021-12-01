# NoAdsInChat
Vẫn là plugin chặn một cụm từ cố định trong chat nhưng kèm theo đó là hack não người chơi.  
Tức là chat vẫn sẽ hiển thị với người vi phạm một cách bình thường, nhưng sẽ bị ẩn đối với toàn bộ người chơi khác. Staff sẽ nhận được thông báo về vi phạm của người chơi.

## Các tính năng chính
 - Không phải là chặn chat, mà là ẩn chat đối với người vi phạm. Người vi phạm sẽ không biết chat của mình không hiển thị đối với người chơi khác.
 - BlacklistDetection: Chặn chat theo danh sách regex cho trước cho trước.
 - SpamDetection: Ẩn chat nếu người chơi chat nhiều hơn x tin nhắn trong khoảng thời gian t mili-giây
 - IPWideBlock: Vẫn hiện chat cho bất kì người chơi nào có cùng IP

## Commands
|Lệnh|Mô tả|
|---|---|
|`/naid reload`|Reload config|
|`/naid notify <on/off> [player]`|Bật tắt thông báo vi phạm|

## Permission
|Permission|Mô tả|
|---|---|
|`noads.bypass`|Không bị ẩn chat bởi plugin này, bypass ấy.|
|`noads.use`|Quyền thi lệnh `/noads` nói chung.|
|`noads.admin`|Quyền thi lệnh `/noads reload`.|
|`noads.notify`|Thực hiện lệnh `/naid notify`.|
|`noads.notify.auto`|Tự động thêm vào danh sách nhận Notification khi đăng nhập.|
